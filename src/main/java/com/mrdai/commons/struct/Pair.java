package com.mrdai.commons.struct;

public class Pair<A, B> {
    public A _1;
    public B _2;

    public static <X, Y> Pair<X, Y> of(X _1, Y _2) {
        return new Pair<>(_1, _2);
    }

    public Pair(A _1, B _2) {
        this._1 = _1;
        this._2 = _2;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Pair) {
            Pair otherPair = (Pair) other;
            boolean _1Match = _1 == null ? otherPair._1 == null : _1.equals(otherPair._1);
            boolean _2Match = _2 == null ? otherPair._2 == null : _2.equals(otherPair._2);
            return _1Match && _2Match;
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", _1, _2);
    }
}
