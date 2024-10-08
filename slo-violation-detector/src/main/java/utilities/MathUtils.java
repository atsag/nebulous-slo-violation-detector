/*
 * Copyright (c) 2023 Institute of Communication and Computer Systems
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */        

package utilities;


import java.util.List;

public class MathUtils {

    public static double get_average(Iterable<Number> values){
        double sum = 0;
        int counter = 0;
        for (Number value :values){
            if (value instanceof Double){
                sum = sum+(Double)value;
            } else if (value instanceof Integer) {
                sum = sum+(Integer)value;
            }
            counter++;
        }
        return (sum/counter);
    }

    public static double sum(Iterable<Double> values) {
        double sum = 0;
        for (Double value : values){
            sum = sum+value;
        }
        return sum;
    }
    
    public static double findmax(Double... values){
        double max = Double.NEGATIVE_INFINITY;
        for (Double value: values){
            if (value>max){
                max = value;
            }
        }
        return max;
    }
}
