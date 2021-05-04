package model;

import java.util.ArrayList;

public enum Figure {
    I1(0, 1, 1, 1, 2, 1, 3, 1),
    I2(1, 0, 1, 1, 1, 2, 1, 3),
    J1(1, 0, 1, 1, 0, 2, 1, 2),
    J2(0, 0, 0, 1, 1, 1, 2, 1),
    J3(1, 0, 2, 0, 1, 1, 1, 0),
    J4(0, 1, 1, 1, 2, 1, 2, 2),
    L1(1, 0, 1, 1, 1, 2, 2, 2),
    L2(0, 1, 1, 1, 2, 1, 0, 2),
    L3(0, 0, 1, 0, 1, 1, 1, 2),
    L4(2, 0, 0, 1, 1, 1, 2, 1),
    O(0, 0, 1, 0, 0, 1, 1, 1),
    S1(1, 1, 2, 1, 0, 2, 1, 2),
    S2(0, 0, 0, 1, 1, 1, 1, 2),
    T1(0, 1, 1, 1, 2, 1, 1, 2),
    T2(1, 0, 0, 1, 1, 1, 1, 2),
    T3(1, 0, 0, 1, 1, 1, 2, 1),
    T4(1, 0, 1, 1, 2, 1, 1, 2),
    Z1(0, 1, 1, 1, 1, 2, 2, 2),
    Z2(2, 0, 1, 1, 2, 1, 1, 2);
    private ArrayList<Coord> dot;

    Figure(int... coords) {
        dot = new ArrayList<Coord>();
        for (int i = 0; i < coords.length; i += 2) {
            dot.add(new Coord(coords[i], coords[i + 1]));
        }
    }

    public Figure go_right() {
        if (this == I1) {
            return I2;
        } else if (this == I2) {
            return I1;
        } else if (this == J1) {
            return J2;
        } else if (this == J2) {
            return J3;
        } else if (this == J3) {
            return J4;
        } else if (this == J4) {
            return J1;
        } else if (this == L1) {
            return L2;
        } else if (this == L2) {
            return L3;
        } else if (this == L3) {
            return L4;
        } else if (this == L4) {
            return L1;
        } else if (this == O) {
            return O;
        } else if (this == S1) {
            return S2;
        } else if (this == S2) {
            return S1;
        } else if (this == T1) {
            return T2;
        } else if (this == T2) {
            return T3;
        } else if (this == T3) {
            return T4;
        } else if (this == T4) {
            return T1;
        } else if (this == Z1) {
            return Z2;
        } else {
            return Z1;
        }
    }

    public Figure go_left() {
        if (this == I1) {
            return I2;
        } else if (this == I2) {
            return I1;
        } else if (this == J1) {
            return J4;
        } else if (this == J2) {
            return J1;
        } else if (this == J3) {
            return J2;
        } else if (this == J4) {
            return J3;
        } else if (this == L1) {
            return L4;
        } else if (this == L2) {
            return L1;
        } else if (this == L3) {
            return L2;
        } else if (this == L4) {
            return L3;
        } else if (this == O) {
            return O;
        } else if (this == S1) {
            return S2;
        } else if (this == S2) {
            return S1;
        } else if (this == T1) {
            return T4;
        } else if (this == T2) {
            return T1;
        } else if (this == T3) {
            return T2;
        } else if (this == T4) {
            return T3;
        } else if (this == Z1) {
            return Z2;
        } else if (this == Z2) {
            return Z1;
        }
        return O;
    }
}
