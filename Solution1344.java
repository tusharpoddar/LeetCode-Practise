// Returns the angle between the hour hand and the minute hand
class Solution {
    public double angleClock(int hour, int minutes) {
        double min = (minutes * 1.0)/ 60;
        double total_time = hour + min; 
        double angle1 = (total_time / 12) * 360;
        double angle2 = (minutes * 1.0 / 60) * 360; 
        double ans = Math.abs(angle1 - angle2);
        if(ans > 180){
            return 360 - ans;
        }else{
            return ans;
        }
    }
}

