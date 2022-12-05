package org.example;

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

    }
}
