package Lesson5;

public enum Months {
    JANUARY (1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);

    int code;
    Months(int code) {
        this.code = code;
    }
    public static Months getNameByCode(int code){
        for(Months e : Months.values()){
            if(code == e.code)
                return e;
        }
        return null;
    }
}
