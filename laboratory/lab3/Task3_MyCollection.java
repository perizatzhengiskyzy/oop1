// Task 3: MyCollection Interface and Implementation

import java.util.Iterator;

interface MyCollection<E> {
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    boolean add(E e);
    boolean remove(Object o);
    void clear();
    boolean addAll(MyCollection<? extends E> c);
    boolean removeAll(MyCollection<?> c);
    boolean retainAll(MyCollection<?> c);
    Object[] toArray();
    <T> T[] toArray(T[] a);
    Iterator<E> iterator();
}

class MyArrayList<E> implements MyCollection<E> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    
    @Override
    public int size() { return size; }
    
    @Override
    public boolean isEmpty() { return size == 0; }
    
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) return true;
        }
        return false;
    }
    
    @Override
    public boolean add(E e) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = e;
        return true;
    }
    
    private void resize() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }
    
    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                elements[i] = elements[size - 1];
                elements[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    
    @Override
    public boolean addAll(MyCollection<? extends E> c) {
        boolean changed = false;
        for (E item : c.toArray((E[]) new Object[0])) {
            changed |= add(item);
        }
        return changed;
    }
    
    @Override
    public boolean removeAll(MyCollection<?> c) {
        boolean changed = false;
        for (Object item : c.toArray()) {
            changed |= remove(item);
        }
        return changed;
    }
    
    @Override
    public boolean retainAll(MyCollection<?> c) {
        boolean changed = false;
        MyArrayList<E> toRemove = new MyArrayList<>();
        for (int i = 0; i < size; i++) {
            if (!c.contains(elements[i])) {
                toRemove.add((E) elements[i]);
            }
        }
        changed = removeAll(toRemove);
        return changed;
    }
    
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(elements, 0, result, 0, size);
        return result;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size) a[size] = null;
        return a;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;
            
            @Override
            public boolean hasNext() {
                return index < size;
            }
            
            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                return (E) elements[index++];
            }
        };
    }
}