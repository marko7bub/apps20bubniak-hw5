package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;

import java.util.ArrayList;

public class AsIntStream implements IntStream {
    private final ArrayList<Integer> stream;

    public AsIntStream(ArrayList<Integer> array) {
        this.stream = array;
    }

    public static IntStream of(int... values) {
        ArrayList<Integer> integerArray = new ArrayList<>();
        for (int integer : values) {
            integerArray.add(integer);
        }
        return new AsIntStream(integerArray);
    }

    @Override
    public Double average() {
        if (this.stream.size() == 0) {
            throw new IllegalArgumentException();
        }
        return ((double) sum() / this.stream.size());
    }

    @Override
    public Integer max() {
        if (this.stream.size() == 0) {
            throw new IllegalArgumentException();
        }
        int max = this.stream.get(0);
        for (int i = 1; i < this.stream.size(); i++) {
            if (max < this.stream.get(i)) {
                max = this.stream.get(i);
            }
        }
        return max;
    }

    @Override
    public Integer min() {
        if (this.stream.size() == 0) {
            throw new IllegalArgumentException();
        }
        int min = this.stream.get(0);
        for (int i = 1; i < this.stream.size(); i++) {
            if (min > this.stream.get(i)) {
                min = this.stream.get(i);
            }
        }
        return min;
    }

    @Override
    public long count() {
        int counter = 0;
        for (int i = 0; i < this.stream.size(); i++) {
            counter += 1;
        }
        return counter;
    }

    @Override
    public Integer sum() {
        if (this.stream.size() == 0) {
            throw new IllegalArgumentException();
        }
        int sum = 0;
        for (int integer : this.stream) {
            sum += integer;
        }
        return sum;
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        ArrayList<Integer> checkedArray = new ArrayList<>();
        for (int integer : this.stream) {
            if (predicate.test(integer)) {
                checkedArray.add(integer);
            }
        }
        return new AsIntStream(checkedArray);
    }

    @Override
    public void forEach(IntConsumer action) {
        for (int integer : this.stream) {
            action.accept(integer);
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        ArrayList<Integer> mappedArray = new ArrayList<>();
        for (int integer : this.stream) {
            int mappedInteger = mapper.apply(integer);
            mappedArray.add(mappedInteger);
        }
        return new AsIntStream(mappedArray);
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        ArrayList<IntStream> flatmappedArray = new ArrayList<>();
        for (int integer : this.stream) {
            IntStream mappedStream = func.applyAsIntStream(integer);
            flatmappedArray.add((AsIntStream) mappedStream);
        }
        ArrayList<Integer> dismappedArray = new ArrayList<>();
        for (IntStream mapped : flatmappedArray) {
            dismappedArray.addAll(((AsIntStream) mapped).stream);
        }
        return new AsIntStream(dismappedArray);
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        int reduced = identity;
        for (int integer : this.stream) {
            reduced = op.apply(reduced, integer);
        }
        return reduced;
    }

    @Override
    public int[] toArray() {
        int[] array = new int[this.stream.size()];
        for (int i = 0; i < this.stream.size(); i++) {
            array[i] = this.stream.get(i);
        }
        return array;
    }
}
