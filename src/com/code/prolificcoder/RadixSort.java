package com.code.prolificcoder;
/* Copyright (c) 2010 the authors listed at the following URL, and/or
the authors of referenced articles or incorporated external code:
http://en.literateprograms.org/Radix_sort_(Java)?action=history&offset=20080201073641

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

Retrieved from: http://en.literateprograms.org/Radix_sort_(Java)?oldid=12461
*/

import java.util.Arrays;


class RadixSort
{
    public static void radix_sort_uint(int[] a, int bits)
    {

        int[] b = new int[a.length];
        int[] b_orig = b;


        int rshift = 0;
        for (int mask = ~(-1 << bits); mask != 0; mask <<= bits, rshift += bits) {

            int[] cntarray = new int[1 << bits];

            for (int p = 0; p < a.length; ++p) {
                int key = (a[p] & mask) >> rshift;
                ++cntarray[key];
            }


    		for (int i = 1; i < cntarray.length; ++i)
                        cntarray[i] += cntarray[i-1];


            for (int p = a.length-1; p >= 0; --p) {
                int key = (a[p] & mask) >> rshift;
                --cntarray[key];
                b[cntarray[key]] = a[p];
            }


            int[] temp = b; b = a; a = temp;
        }


        if (a == b_orig)
            System.arraycopy(a, 0, b, 0, a.length);
    }

    public static void main(String[] args)
    {
        int[] a = {
            123,432,654,3123,654,2123,543,131,653,123,
            533,1141,532,213,2241,824,1124,42,134,411,
            491,341,1234,527,388,245,1992,654,243,987};
        int[] a1={25,1313,5131,731,631,531,31,713,6,42,10,1000,0,90};

        System.out.println("Before radix sort:");
        System.out.println(Arrays.toString(a1));

        radix_sort_uint(a1, 4);

        System.out.println("After radix sort:");
        System.out.println(Arrays.toString(a1));
    }

}

