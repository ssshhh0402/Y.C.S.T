public class ProgrammerDay {
    public static boolean getFlag(int year){
        if(year <= 1917){
            if(year % 4 == 0){
                return true;
            }
        }else if(year >= 1919){
            if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
                return true;
            }
        }
        return false;
    }
    public static String dayOfProgrammer(int year){
        boolean flag = getFlag(year);
        StringBuilder sb = new StringBuilder();
        //1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
        int [] days = new int [] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int counts = 256;
        for(int i = 1; i < 13; i++){
            if(counts - days[i] <= 0){
                sb.append(counts).append(".");
                if(i < 10){
                    sb.append("0").append(i).append(".");
                }else{
                    sb.append(i).append(".");
                }
                sb.append(year);
                break;
            }else{
                counts -= days[i];
            }
            if(i == 2){
                if(year == 1918){
                    counts +=  13;
                }else if(flag){
                    counts -= 1;
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        int year = 2017;
//        System.out.println(dayOfProgrammer(year));
        year = 2016;
        System.out.println(dayOfProgrammer(year));
    }
}
