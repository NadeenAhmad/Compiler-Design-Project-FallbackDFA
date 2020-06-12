//T07_37_4023_Nadeen_Ahmad_Shoukry

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FDFA {
	public static String help(String test, ArrayList<String> states,
			ArrayList<String> zero, ArrayList<String> one,
			ArrayList<String> actions, ArrayList<String> AcceptStates2) {

		String currentState = "0";
		ArrayList<String> stackOfStates = new ArrayList<String>();
		for (int j = 0; j < test.length(); j++) {
			if (test.charAt(j) == '0') {
				String tmp = zero.get(states.indexOf(currentState));
				currentState = tmp;
				stackOfStates.add(tmp);

			} else if (test.charAt(j) == '1') {

				String tmp = one.get(states.indexOf(currentState));
				currentState = tmp;
				stackOfStates.add(tmp);
			}

		}
		// System.out.println("states in test string " + stackOfStates);

		String lastAccept = "";
		int indexOfLastAccept = -1;
		String ActionOfLastAccept = "";
		boolean contains = false;

		for (int x = 0; x < stackOfStates.size(); x++) {
			for (String c : AcceptStates2) {
				if (c.equals(stackOfStates.get(x))) {
					contains = true;
					indexOfLastAccept = x;
					lastAccept = c;
					ActionOfLastAccept = actions.get(states.indexOf(c));
					break;
				}
			}

		}
		String theRest = "";

		if (contains) {
			theRest = test.substring(indexOfLastAccept + 1);

		}

		if (!contains) {
			ActionOfLastAccept = actions.get(states.indexOf(stackOfStates
					.get(stackOfStates.size() - 1)));

		}
		// System.out.println("Last Accept State "+ lastAccept);
		// System.out.println("Index in test String " + indexOfLastAccept);

		System.out.print(ActionOfLastAccept);

		// System.out.println(theRest);
		return theRest;
	}

	public static void fdfa(String fdfa, String t) {
		System.out.println();
		System.out.println("input string: " + t);
		System.out.println();
		// Save accept states into a separate array
		ArrayList<String> AcceptStates2 = new ArrayList<String>();
		int i = 0;
		while (fdfa.charAt(i) != '#' && i < fdfa.length() - 1) {
			i++;
		}
		if (i != fdfa.length()) {
			String AcceptStates = fdfa.substring(i + 1);
			AcceptStates2 = new ArrayList<>(Arrays.asList(AcceptStates
					.split(",")));

			// System.out.println("Accept States " + AcceptStates2);

		}

		// Save DFA states in an array
		String rest = fdfa.substring(0, i);
		ArrayList<String> rest2 = new ArrayList<>(
				Arrays.asList(rest.split(";")));
		// Save states
		ArrayList<String> states = new ArrayList<String>();

		for (int x = 0; x < rest2.size(); x++) {
			states.add(rest2.get(x).charAt(0) + "");
		}
		// System.out.println("States" + states);

		// Save zero transitions
		ArrayList<String> zero = new ArrayList<String>();

		for (int x = 0; x < rest2.size(); x++) {
			zero.add(rest2.get(x).charAt(2) + "");
		}
		// System.out.println("zero transitions " + zero);

		// Save one transitions
		ArrayList<String> one = new ArrayList<String>();

		for (int x = 0; x < rest2.size(); x++) {
			one.add(rest2.get(x).charAt(4) + "");
		}
		// System.out.println("one transitions " + one.toString());

		// Save Actions
		ArrayList<String> actions = new ArrayList<String>();
		for (int j = 0; j < rest2.size(); j++) {
			ArrayList<String> tmp = new ArrayList<>(Arrays.asList(rest2.get(j)
					.split(",")));

			actions.add(tmp.get(3));

		}
		// System.out.println("actions" + actions);

		boolean check = false;

		while (!check) {
			String r = help(t, states, zero, one, actions, AcceptStates2);
			if (r.isEmpty()) {
				check = true;
			} else {
				t = r;
			}

		}

	}

	public static void main(String[] args) {
		// parse("0,0,1,00;1,2,1,01;2,0,3,10;3,3,3,11#0,1,2","011");
		// parse("0,0,1,00;1,0,1,01#1");
//		fdfa("0,1,0,00;1,1,2,01;2,1,3,10;3,1,0,11#3", "0100");
//		fdfa("0,1,0,00;1,1,2,01;2,1,3,10;3,1,0,11#3", "10011");
//		fdfa("0,1,0,00;1,1,2,01;2,1,3,10;3,1,0,11#3", "1000011011");
//		fdfa("0,1,0,00;1,1,2,01;2,1,3,10;3,1,0,11#3", "011001");
//		fdfa("0,1,0,00;1,1,2,01;2,1,3,10;3,1,0,11#3", "1001111010");

		
//		
//		fdfa("0,1,0,00;1,0,2,01;2,0,2,11#1", "011110");
//		fdfa("0,1,0,00;1,0,2,01;2,0,2,11#1", "110110");
//		fdfa("0,1,0,00;1,0,2,01;2,0,2,11#1", "010011");
//		fdfa("0,1,0,00;1,0,2,01;2,0,2,11#1", "01111");
//		fdfa("0,1,0,00;1,0,2,01;2,0,2,11#1", "1011011");
//		
		fdfa("0,0,1,00;1,2,1,01;2,0,3,10;3,3,3,11#0,1,2","1011100");
	}
}
