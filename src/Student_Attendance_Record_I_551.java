public class Student_Attendance_Record_I_551 {

    /*You are given a string representing an attendance record for a student. The record only contains the following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.*/

    public static void main (String[] args){

        System.out.println(checkRecord("LL")); // true
//        System.out.println(checkRecord("PPALL")); //true
//        System.out.println(checkRecord("PPAALL")); //false - 2A
//        System.out.println(checkRecord("PPPALLL")); // false - 3A
//        System.out.println(checkRecord("PAPALL")); // false - 2A
//        System.out.println(checkRecord("PLPALL")); // true
//        System.out.println(checkRecord("LLLL")); // false


    }

    public static boolean checkRecord(String s){
        char[] attendance = s.toCharArray();
        int lCount = 0;
        int aCount = 0;

        for(int i =0;i<attendance.length; i++){
            if(attendance[i] == 'A'){
                aCount++;
                if(aCount > 1){
                    return false;
                }
            }
            else if(attendance[i] == 'L'){
                if(i==0 || attendance[i-1] == 'L' ){
                    lCount++;
                }

                if(lCount > 2){
                    return false;
                }
            }

        }
        return true;
    }
}
