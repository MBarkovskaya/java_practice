package ua.nure.barkovskaya.practice2;


import java.util.*;
import java.util.function.Consumer;

public class MyListImpl implements MyList, ListIterable {
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private int modCount = 0;
    private Object[] elementData;
    private int size;

    public MyListImpl() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }


    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    public void add(Object e) {
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
    }

    // removes all of the elements from this list
    public void clear() {
        modCount++;

        // clear to let GC do its work
        for (int i = 0; i < size; i++)
            elementData[i] = null;

        size = 0;
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }

    private void fastRemove(int index) {
        modCount++;
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index,
                    numMoved);
        elementData[--size] = null; // clear to let GC do its work
    }

    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    // returns the number of elements in this list
    public int size() {
        return size;
    }
    // returns true if this list contains the specified element

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    private int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    // returns true if this list contains all of the elements
    //​ of the specified list

    public boolean containsAll(MyList anotherList) {
        if (anotherList == null) {
            throw new IllegalArgumentException();
        }

        Object[] anotherData = anotherList.toArray();
        for (Object anotherObj : anotherData) {
            if (!this.contains(anotherObj)) {
                return false;
            }
        }
        return true;
    }

    public Object set(int index, Object element) {
        rangeCheck(index);

        Object oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }

    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private Object elementData(int index) {
        return elementData[index];
    }

    public String toString() {
        int iMax = this.size();
        if (iMax == 0) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; i < iMax; i++) {
            b.append(elementData[i]);
            if (i < iMax - 1) {
                b.append(", ");
            } else {
                b.append(']');
            }
        }
        return b.toString();
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    public ListIterator listIterator() {
        return new ListIteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = modCount;

        IteratorImpl() {
        }

        public boolean hasNext() {
            return cursor != size;
        }

        public Object next() {
//            checkForComodification();
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = MyListImpl.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return elementData[lastRet = i];
        }

        public void forEachRemaining(Consumer<? super Object> consumer) {
            Objects.requireNonNull(consumer);
            final int size = MyListImpl.this.size;
            int i = cursor;
            if (i >= size) {
                return;
            }
            final Object[] elementData = MyListImpl.this.elementData;
            if (i >= elementData.length) {
                throw new ConcurrentModificationException();
            }
            while (i != size && modCount == expectedModCount) {
                consumer.accept(elementData[i++]);
            }
            // update once at end of iteration to reduce heap write traffic
            cursor = i;
            lastRet = i - 1;
            checkForComodification();
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                MyListImpl.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public class ListIteratorImpl extends IteratorImpl implements ListIterator {
        // returns true if this list iterator has more elements when traversing
        // ​the list in the reverse direction
        ListIteratorImpl() {
        }

        public boolean hasPrevious() {
            // returns the previous element in the list and moves the cursor
            // ​position backwards
            return cursor != 0;
        }

        public Object previous() {
            // replaces the last element returned by next or previous with
            // ​the specified element
            checkForComodification();
            int i = cursor - 1;
            if (i < 0)
                throw new NoSuchElementException();
            Object[] elementData = MyListImpl.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i;
            return elementData[lastRet = i];
        }

        public void set(Object e) {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                MyListImpl.this.set(lastRet, e);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

    }
}
