package org.example;

import javax.sound.midi.Soundbank;

public class Array {

    private int[] array;
    private int firsFreeIndex;

    public Array(int length){
        this.array = new int[length];
        this.firsFreeIndex = 0;
    }

    public void insert(int item){
        if(!(firsFreeIndex == array.length)){
            this.grow();
        }

        array[firsFreeIndex] = item;
        firsFreeIndex++;
    }


    private void grow(){
        int newSize = (array.length * 2) - array.length / 2 ;
        int[] buffer = new int[newSize];

        for(int i = 0; i < array.length; i++){
            buffer[i] = array[i];
        }

        this.array = buffer;
    }

    public int get(int index){
        return array[index];
    }

    public void removeAt(int indexAt){

        if(indexAt >= firsFreeIndex || indexAt > array.length){
            throw new IllegalArgumentException();
        }

        for (int i = indexAt; i < firsFreeIndex; i++) {
            array[i] = array[i + 1];
        }

        firsFreeIndex--;
    }

    public int indexOf(int target){
        int output = -1;

        for (int i = 0; i < firsFreeIndex; i++) {
            if (array[i] == target){
                output = i;
                break;
            }
        }
        return output;
    }

    public void print(){
        for (int i = 0; i < firsFreeIndex; i++) {
            System.out.println(array[i]);
        }
    }
}
