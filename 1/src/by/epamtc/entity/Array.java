package by.epamtc.entity;

public class Array {
    private int[] array;
    private int size;

    public Array(){}

    public Array(int[] arr){
        if(arr != null){
            this.array = arr;

            for (int x : array)
                size += 1;
        } else {
            //NullPtrException
        }
    }

    public Array(int[] arr, int arrSize) {
        if(arr != null && arrSize > 0) {
            this.array = arr;
            this.size = arrSize;
        } else {
            //BadDataException
        }
    }

    public int get(int index)
    {
        if(index > 0)
            return array[index];
        else {
            //exception
            return -1;
        }
    }

    public void replace(int index, int value)
    {
        if(index >= 0 && index < size)
            array[index] = value;
        else {
            //ArrayOutOfBoundException
        }
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        if (array != null)
            this.array = array;
        else {
            //NullPtrException
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {

        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Array arr = (Array) o;

        if (size != arr.size) return false;

        for (int i = 0; i < this.size; i++)
            if(this.array[i] != arr.array[i])
                return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;

        for(int x : array)
            result = 31 * result + x;

        return 31 * result + size;
    }

    @Override
    public String toString() {
        StringBuilder stringArr = new StringBuilder();

        for(int x : array)
            stringArr.append(x).append(" ");

        return "Array{" +
                "array=" + stringArr +
                ", arrSize=" + size +
                '}';
    }
}