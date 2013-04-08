import java.util.ArrayList;
import java.util.Collections;



public class Operations {

	public static String fromDay;
	public static String toDay;
	public static String fromTime;
	public static String toTime;
	public static String output = "";
	public static String out_combined = "";

	public String unpack(ArrayList<String[]> packed,String fromDay, String toDay, String fromTime, String toTime){

		this.fromDay = fromDay;
		this.toDay = toDay;
		this.fromTime = fromTime;
		this.toTime = toTime;

		int[] secs = new int[packed.size()];
		for(int i = 0; i < packed.size(); i++){
			secs[i] = packed.get(i).length-1;
		}
		int[] secs_org = new int[secs.length];
		for(int i = 0; i < secs.length; i++){
			secs_org[i] = secs[i];
		}
		//System.out.print("<html><head><title>Generated By Lecture Combinator</title></head><body>");
		output+="<html><head><title>Generated By Lecture Combinator</title></head><body>";
		combine(secs,secs_org,secs.length-1,packed);
		//System.out.print("</body></html>");
		output+="</body></html>";
		
		return output;
	}

	public static String combine(int[] secs, int[] secs_org, int level,ArrayList<String[]> packed){ // level = array.length-1
		String[] selected = new String[secs.length];
		try{
			//print
			for(int i = 0; i < secs.length; i++){
				selected[i] = packed.get(i)[secs[i]];
				//System.out.print(packed.get(i)[secs[i]]+" ");
			}
			out_combined += tableify(selected);

			if (secs[level] != 0){
				secs[level]--;
				combine(secs,secs_org,level,packed);
			}
			else{
				while(secs[level] == 0){
					level--;
				}
				secs[level]--;
				for(int i = level+1; i<secs.length; i++){
					secs[i] = secs_org[i];
				}
				level = secs.length-1;
				combine(secs,secs_org,level,packed);
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			//e.printStackTrace();
			return out_combined;
		}
		return ""; // ???
	}


	public static String tableify(String[] selected){
		for(int i = 0; i < selected.length; i++){
			for(int j = 0; j < selected.length; j++){
				if (i != j){
					int cnt1 = 2;
					while(true){
						int cnt2 = 2;
						try{
							String deneme = selected[i].split("\\|")[cnt1];
						} catch(Exception e){break;}
						while(true){
							try{
								String deneme = selected[j].split("\\|")[cnt2];
							} catch(Exception e){break;}
							if (selected[i].split("\\|")[cnt1].equals(selected[j].split("\\|")[cnt2])){
								if (!((timetoint(selected[i].split("\\|")[cnt1+2]) <= timetoint(selected[j].split("\\|")[cnt2+1])) || (timetoint(selected[i].split("\\|")[cnt1+1]) >= timetoint(selected[j].split("\\|")[cnt2+2])))){
									return null; // ???
									//break;
								}
							}
							cnt2 += 3;
						}
						cnt1 += 3;
					}
				}
			}
		}
		return generateTable(selected);
	}


	public static String generateTable(String[] selected){

		//for(int i = 0; i < selected.length; i++){
		//	System.out.print(selected[i] + " ");
		//}
		//System.out.println();

		//System.out.print("<table width='700' height='500' border='1' cellspacing='0' cellpadding='0'>");
		output+="<table width='700' height='500' border='1' cellspacing='0' cellpadding='0'>";
		//System.out.print("<tr height='30'>");
		output+="<tr height='30'>";
		int tdnum = daytoint(toDay) - daytoint(fromDay);
		for(int i = 0; i <= tdnum; i++){
			//System.out.print("<td align='center' valign='middle' bgcolor='#000000' width='"+Math.round((double)100/(tdnum+1))+"%' style='color:#FFF; font-weight:bold;'>"+Combinator.days[i]+"</td>");
			output+="<td align='center' valign='middle' bgcolor='#000000' width='"+Math.round((double)100/(tdnum+1))+"%' style='color:#FFF; font-weight:bold;'>"+Combinator.days[i]+"</td>";
		}
		//System.out.print("</tr><tr>");
		output+="</tr><tr>";
		for(int i = 0; i <= tdnum; i++){
			//System.out.print("<td>");
			output+="<td>";
			ArrayList<Integer> dayline = new ArrayList<Integer>();
			dayline.add(timetoint(fromTime));
			dayline.add(timetoint(toTime));
			for(int j = 0; j < selected.length; j++){
				int cnt = 2;
				while(true){
					try{
						if (selected[j].split("\\|")[cnt].equals(Combinator.days[i])){
							dayline.add(timetoint(selected[j].split("\\|")[cnt+1]));
							dayline.add(timetoint(selected[j].split("\\|")[cnt+2]));
						}
					}catch(Exception e){break;}
					cnt += 3;
				}
			}
			dayline = removeSame(dayline);
			Collections.sort(dayline);
			//System.out.print("<table width='100%' height='100%' border='0' cellspacing='0' cellpadding='0'>");
			output+="<table width='100%' height='100%' border='0' cellspacing='0' cellpadding='0'>";
			int summed = 0;
			boolean emptyday = true;
			for(int sum = 0; sum < dayline.size(); sum++){
				if (sum!=0){
					summed += dayline.get(sum) - dayline.get(sum-1);
				}
			}
			for(int x = 1; x < dayline.size(); x++){
				boolean draw = false;
				for(int y = 0; y < selected.length; y++){
					int cnt = 2;
					while(true){
						try{
							if ((selected[y].split("\\|")[cnt].equals(Combinator.days[i]))&&(timetoint(selected[y].split("\\|")[cnt+1]) == dayline.get(x-1))&&(timetoint(selected[y].split("\\|")[cnt+2]) == dayline.get(x))){
									//System.out.print("<tr align='center' valign='middle' bgcolor='#CCCCCC' height='"+Math.round(((double)(dayline.get(x)-dayline.get(x-1))/summed)*100)+"%'><td>"+selected[y].split("\\|")[0]+" "+selected[y].split("\\|")[1]+"<br>"+selected[y].split("\\|")[cnt+1]+"-"+selected[y].split("\\|")[cnt+2]+"</td></tr>");
									output+="<tr align='center' valign='middle' bgcolor='#CCCCCC' height='"+Math.round(((double)(dayline.get(x)-dayline.get(x-1))/summed)*100)+"%'><td>"+selected[y].split("\\|")[0]+" "+selected[y].split("\\|")[1]+"<br>"+selected[y].split("\\|")[cnt+1]+"-"+selected[y].split("\\|")[cnt+2]+"</td></tr>";
									emptyday = false;
									draw = true;
								}
						}catch(Exception e){break;}
						cnt += 3;
					}
				}
				if (!draw){
				//System.out.print("<tr align='center' valign='middle' height='"+Math.round(((double)(dayline.get(x)-dayline.get(x-1))/summed)*100)+"%'><td></td></tr>");
				output+="<tr align='center' valign='middle' height='"+Math.round(((double)(dayline.get(x)-dayline.get(x-1))/summed)*100)+"%'><td></td></tr>";
				emptyday = false;
				}
			}
			if (emptyday){
				//System.out.print("<tr><td></tr></td>");
				output+="<tr><td></tr></td>";
			}
			//System.out.print("</table>");
			output+="</table>";

			//System.out.print("</td>");
			output+="</td>";
		}
		//System.out.print("</table><br><br>");
		output+="</table><br><br>";

		
		return output;
	}


	public static ArrayList<Integer> removeSame(ArrayList<Integer> ints){
		for(int i = 0; i < ints.size(); i++){
			int cur = ints.get(i);
			for(int j = 0; j < ints.size(); j++){
				if ((ints.get(j) == cur) && (i!=j)){
					ints.remove(j);
				}
			}
		}
		return ints; 
	}

	public static int timetoint(String str){
		str = str.replace(":", "");
		return Integer.parseInt(str);
	}

	public static int daytoint(String day){
		if (day.equals("Monday")){
			return 0;
		}
		else if (day.equals("Tuesday")){
			return 1;
		}
		else if (day.equals("Wednesday")){
			return 2;
		}
		else if (day.equals("Thursday")){
			return 3;
		}
		else if(day.equals("Friday")){
			return 4;
		}
		else if (day.equals("Saturday")){
			return 5;
		}
		else if (day.equals("Sunday")){
			return 6;
		}
		else{
			return -1;
		}
	}
}


















