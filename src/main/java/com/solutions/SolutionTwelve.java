package com.solutions;

public class SolutionTwelve {
    public String intToRoman(int num) {
        String ans = "";
        int[] numBit = {0, 0, 0, 0};
        int index = 0;
        while (num != 0) {
            numBit[index] = num % 10;
            num /= 10;
            index++;
        }
        if (numBit[3] != 0) {
            for (int i = 1; i <= numBit[3]; i++) {
                ans += "M";
            }
        }
        if (numBit[2] != 0) {
            if (numBit[2] <= 3) {
                for (int i = 1; i <= numBit[2]; i++) {
                    ans += "C";
                }
            } else if (numBit[2] == 4) {
                ans += "CD";
            } else if (numBit[2] >= 5 && numBit[2] < 9) {
                ans += "D";
                for (int i = numBit[2]; i > 5; i--) {
                    ans += "C";
                }
            } else {
                ans += "CM";
            }
        }
        if (numBit[1] != 0) {
            if (numBit[1] <= 3) {
                for (int i = 1; i <= numBit[1]; i++) {
                    ans += "X";
                }
            } else if (numBit[1] == 4) {
                ans += "XL";
            } else if (numBit[1] >= 5 && numBit[1] < 9) {
                ans += "L";
                for (int i = numBit[1]; i > 5; i--) {
                    ans += "X";
                }
            } else {
                ans += "XC";
            }
        }
        if (numBit[0] != 0) {
            if (numBit[0] <= 3) {
                for (int i = 1; i <= numBit[0]; i++) {
                    ans += "I";
                }
            } else if (numBit[0] == 4) {
                ans += "IV";
            } else if (numBit[0] >= 5 && numBit[0] < 9) {
                ans += "V";
                for (int i = numBit[0]; i > 5; i--) {
                    ans += "I";
                }
            } else {
                ans += "IX";
            }
        }
        return ans;
    }
}
