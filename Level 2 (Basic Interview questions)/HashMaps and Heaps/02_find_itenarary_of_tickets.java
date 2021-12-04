/*abstract
1. You are given number N and 2*N number of strings that represent a list of N tickets(source and destination).
2. You have to find the itinerary in order using the given list of tickets.

Assumption -> The input list of tickets is not cyclic and there is one ticket from every city except the final destination.
Input Format
A number N
N number of lines, where each line contains 2 strings.
Output Format
Check the sample ouput and question video.
Question Video

  COMMENTConstraints
1 <= N <= 100
Sample Input
4
Chennai Banglore 
Bombay Delhi 
Goa Chennai 
Delhi Goa 
Sample Output
Bombay -> Delhi -> Goa -> Chennai -> Banglore.
*/

import java.util.*;

class find_itenarary_of_tickets {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}

		//write your code here

        HashSet<String> cities = new HashSet<>();

        for(String city:map.keySet()){
            cities.add(city);
            cities.add(map.get(city));
        }

        for(String city:map.keySet()){
            StringBuilder psf = new StringBuilder(city);
            int cnt = city_tour(city, map, new HashSet<>(), psf);
            if(cnt == cities.size()){
                psf.append(".");
                System.out.println(psf);
                break;
            }
        }
	}

    public static int city_tour(String src, HashMap<String, String> map, HashSet<String> visited, StringBuilder psf){

        if(src == null){
            return 0;
        }

        if(visited.contains(src)){
            // psf.append(".");
            return 1;
        }
        
        visited.add(src);
        String next = map.get(src);
        int cnt = 1;
        if(next != null){
            psf.append(" -> "+next);
            cnt += city_tour(map.get(src), map, visited, psf);
        }
        return cnt;
    }
}
