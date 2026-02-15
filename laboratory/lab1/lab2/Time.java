package lab1.lab2;

public class Time {
    private int hour;
    private int minute;
    private int second;
    
    public Time(int hour , int minute , int second) {
    	this.hour=hour;
    	this.minute=minute;
    	this.second=second;
    }

    public String toUniversal() {
    	return String.format("%02d:%02d:%02d" , hour , minute , second);
    }

    public String toStandard() {
        int standardHour = hour%12;
        if(standardHour==0) standardHour = 12;
        String amPm = (hour < 12) ? "AM" : "PM";
        return String.format("%02d:%02d;%02d %s", standardHour, minute, second ,amPm);
    }
    public void add(Time t) {
        int totalsecond = this.second+t.second;
        int extraminutes = totalsecond/60;
        this.second+= totalsecond%60;
        
        int totalminute = this.minute +t.minute +  extraminutes;
        int extrahour = totalminute/60;
        this.minute += totalminute%60;
        
        this.hour +=(t.hour + extrahour);
        this.hour=this.hour%24;
    }

    public static void main(String[] args) {
        Time t1 = new Time(23, 5, 6);
        Time t2 = new Time(4, 24, 33);

        System.out.println(t1.toUniversal());  // "23:05:06"
        System.out.println(t1.toStandard());   // "11:05:06 PM"

        t1.add(t2); 
        System.out.println("After addition:");
        System.out.println(t1.toUniversal());  // "03:29:39"
        System.out.println(t1.toStandard());   // "03:29:39 AM"
    }
}