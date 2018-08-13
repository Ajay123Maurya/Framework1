package com.framework.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class KeyboardRobot {
	 Robot rb;

	public void useKeyBoardGetText(char ch)throws AWTException {
		rb =new Robot();
		if(Character.isUpperCase(ch)) {
				 rb.keyPress(KeyEvent.VK_SHIFT);
			 }
			switch(ch) {
			 case 'a':
			 case 'A':
				 rb.keyPress(KeyEvent.VK_A); 
				 rb.keyRelease(KeyEvent.VK_A);
				 break;
			 case 'b':
			 case 'B':
				 rb.keyPress(KeyEvent.VK_B); 
				 rb.keyRelease(KeyEvent.VK_B);
				 break;
			 case 'c':
			 case 'C':
				 rb.keyPress(KeyEvent.VK_C); 
				 rb.keyRelease(KeyEvent.VK_C);
				 break;
			 case 'd':
			 case 'D':
				 rb.keyPress(KeyEvent.VK_D); 
				 rb.keyRelease(KeyEvent.VK_D);
				 break;
			 case 'e':
			 case 'E':
				 rb.keyPress(KeyEvent.VK_E); 
				 rb.keyRelease(KeyEvent.VK_E);
				 break;
			 case 'f':
			 case 'F':
				 rb.keyPress(KeyEvent.VK_F); 
				 rb.keyRelease(KeyEvent.VK_F);
				 break;
			 case 'g':
			 case 'G':
				 rb.keyPress(KeyEvent.VK_G); 
				 rb.keyRelease(KeyEvent.VK_G);
				 break;
			 case 'h':
			 case 'H':
				 rb.keyPress(KeyEvent.VK_H); 
				 rb.keyRelease(KeyEvent.VK_H);
				 break;
			 case 'i':
			 case 'I':
				 rb.keyPress(KeyEvent.VK_I); 
				 rb.keyRelease(KeyEvent.VK_I);
				 break;
			 case 'j':
			 case 'J':
				 rb.keyPress(KeyEvent.VK_J); 
				 rb.keyRelease(KeyEvent.VK_J);
				 break;
			 case 'k':
			 case 'K':
				 rb.keyPress(KeyEvent.VK_K); 
				 rb.keyRelease(KeyEvent.VK_K);
				 break;
			 case 'l':
			 case 'L':
				 rb.keyPress(KeyEvent.VK_L); 
				 rb.keyRelease(KeyEvent.VK_L);
				 break;
			 case 'm':
			 case 'M':
				 rb.keyPress(KeyEvent.VK_M); 
				 rb.keyRelease(KeyEvent.VK_M);
				 break;
			 case 'n':
			 case 'N':
				 rb.keyPress(KeyEvent.VK_N); 
				 rb.keyRelease(KeyEvent.VK_N);
				 break;
			 case 'o':
			 case 'O':
				 rb.keyPress(KeyEvent.VK_O); 
				 rb.keyRelease(KeyEvent.VK_O);
				 break;
			 case 'p':
			 case 'P':
				 rb.keyPress(KeyEvent.VK_P); 
				 rb.keyRelease(KeyEvent.VK_P);
				 break;
			 case 'q':
			 case 'Q':
				 rb.keyPress(KeyEvent.VK_Q); 
				 rb.keyRelease(KeyEvent.VK_Q);
				 break;
			 case 'r':
			 case 'R':
				 rb.keyPress(KeyEvent.VK_R); 
				 rb.keyRelease(KeyEvent.VK_R);
				 break;
			 case 's':
			 case 'S':
				 rb.keyPress(KeyEvent.VK_S); 
				 rb.keyRelease(KeyEvent.VK_S);
				 break;
			 case 't':
			 case 'T':
			     rb.keyPress(KeyEvent.VK_T); 
	             rb.keyRelease(KeyEvent.VK_T);
				 break;
			 case 'u':
			 case 'U':
				 rb.keyPress(KeyEvent.VK_U); 
				 rb.keyRelease(KeyEvent.VK_U);
				 break;
			 case 'v':
			 case 'V':
				 rb.keyPress(KeyEvent.VK_V); 
				 rb.keyRelease(KeyEvent.VK_V);
				 break;
			 case 'w':
			 case 'W':
				 rb.keyPress(KeyEvent.VK_W); 
				 rb.keyRelease(KeyEvent.VK_W);
				 break;
			 case 'x':
			 case 'X':
				 rb.keyPress(KeyEvent.VK_X); 
				 rb.keyRelease(KeyEvent.VK_X);
				 break;
			 case 'y':
			 case 'Y':
				 rb.keyPress(KeyEvent.VK_Y); 
				 rb.keyRelease(KeyEvent.VK_Y);
				 break;
			 case 'z':
			 case 'Z':
				 rb.keyPress(KeyEvent.VK_Z); 
				 rb.keyRelease(KeyEvent.VK_Z);
				 break;
			 }
			rb.keyRelease(KeyEvent.VK_SHIFT);
		 }
		 
		 	public void useKeyboardGetSpecialCharacter(char st) throws AWTException {
		 		rb =new Robot();
		 		 rb.keyPress(KeyEvent.VK_SHIFT);
		 		switch(st) {
				case '!':
					 rb.keyPress(KeyEvent.VK_1); 
					 rb.keyRelease(KeyEvent.VK_1);
					 break;
				 case '@':
					 rb.keyPress(KeyEvent.VK_2); 
					 rb.keyRelease(KeyEvent.VK_2);
					 break;
				 case '#':
					 rb.keyPress(KeyEvent.VK_3); 
					 rb.keyRelease(KeyEvent.VK_3);
					 break;
				 case '$':
					 rb.keyPress(KeyEvent.VK_4); 
					 rb.keyRelease(KeyEvent.VK_4);
					 break;
				 case '%':
					 rb.keyPress(KeyEvent.VK_E); 
					 rb.keyRelease(KeyEvent.VK_E);
					 break;
				 case '^':
					 rb.keyPress(KeyEvent.VK_F); 
					 rb.keyRelease(KeyEvent.VK_F);
					 break;
				 case '&':
					 rb.keyPress(KeyEvent.VK_G); 
					 rb.keyRelease(KeyEvent.VK_G);
					 break;
				 case '*':
					 rb.keyPress(KeyEvent.VK_H); 
					 rb.keyRelease(KeyEvent.VK_H);
					 break;
				 case '(':
					 rb.keyPress(KeyEvent.VK_I); 
					 rb.keyRelease(KeyEvent.VK_I);
					 break;
				 case ')':
					 rb.keyPress(KeyEvent.VK_I); 
					 rb.keyRelease(KeyEvent.VK_I);
					 break;
		 		
		 	}
		 		rb.keyRelease(KeyEvent.VK_SHIFT);
		 	}
	public void useKeyboardGetNumber(char st) throws AWTException {
		rb =new Robot();
		 		switch(st) {
				 case '1':
				     rb.keyPress(KeyEvent.VK_1); 
					 rb.keyRelease(KeyEvent.VK_1);
					 break;
				 case '2':
			         rb.keyPress(KeyEvent.VK_2); 
					 rb.keyRelease(KeyEvent.VK_2);
					 break;
				 case '3':
					 rb.keyPress(KeyEvent.VK_3); 
					 rb.keyRelease(KeyEvent.VK_3);
					 break;
				 case '4':
					 rb.keyPress(KeyEvent.VK_4); 
					 rb.keyRelease(KeyEvent.VK_4);
					 break;
				 case '5':
					 rb.keyPress(KeyEvent.VK_5); 
					 rb.keyRelease(KeyEvent.VK_5);
					 break;
				 case '6':
					 rb.keyPress(KeyEvent.VK_6); 
					 rb.keyRelease(KeyEvent.VK_6);
					 break;
				 case '7':
					 rb.keyPress(KeyEvent.VK_7); 
					 rb.keyRelease(KeyEvent.VK_7);
					 break;
				 case '8':
					 rb.keyPress(KeyEvent.VK_8); 
					 rb.keyRelease(KeyEvent.VK_8);
					 break;
				 case '9':
					 rb.keyPress(KeyEvent.VK_9); 
					 rb.keyRelease(KeyEvent.VK_9);
					 break;
				 case '0':
					 rb.keyPress(KeyEvent.VK_0); 
					 rb.keyRelease(KeyEvent.VK_0);
					 break;
		 		
		 	}
		 	}	
	public void useKeyboardClickSpecialButton(String st) throws AWTException {
		rb =new Robot();
		 		switch(st) {
				 case "Tab":
				     rb.keyPress(KeyEvent.VK_TAB); 
				//	 rb.keyRelease(KeyEvent.VK_TAB);
					 break;
				 case "Shift":
			         rb.keyPress(KeyEvent.VK_SHIFT); 
				//	 rb.keyRelease(KeyEvent.VK_SHIFT);
					 break;
				 case "Enter":
					 rb.keyPress(KeyEvent.VK_ENTER); 
				//	 rb.keyRelease(KeyEvent.VK_ENTER);
					 break;
				 case "Alt":
					 rb.keyPress(KeyEvent.VK_ALT);
					// rb.keyRelease(KeyEvent.VK_ALT);
					 break;
				 case "Ctrl":
					 rb.keyPress(KeyEvent.VK_CONTROL); 
					// rb.keyRelease(KeyEvent.VK_CONTROL);
					 break;
				 case "Delete":
					 rb.keyPress(KeyEvent.VK_DELETE); 
				//	 rb.keyRelease(KeyEvent.VK_DELETE);
					 break;
				 case "Insert":
					 rb.keyPress(KeyEvent.VK_INSERT); 
				//   rb.keyRelease(KeyEvent.VK_INSERT);
					 break;
				 case "Backslace":
					 rb.keyPress(KeyEvent.VK_BACK_SLASH); 
				//	 rb.keyRelease(KeyEvent.VK_BACK_SLASH);
					 break;
				 case "Backspace":
					 rb.keyPress(KeyEvent.VK_BACK_SPACE); 
				//	 rb.keyRelease(KeyEvent.VK_BACK_SPACE);
					 break;
		 	}
		 	}	
	public void useKeyboardReleaseSpecialButton(String st) throws AWTException {
		rb =new Robot();
		 		switch(st) {
				 case "Tab":
				 //    rb.keyPress(KeyEvent.VK_TAB); 
					 rb.keyRelease(KeyEvent.VK_TAB);
					 break;
				 case "Shift":
			      //   rb.keyPress(KeyEvent.VK_SHIFT); 
					 rb.keyRelease(KeyEvent.VK_SHIFT);
					 break;
				 case "Enter":
					// rb.keyPress(KeyEvent.VK_ENTER); 
					 rb.keyRelease(KeyEvent.VK_ENTER);
					 break;
				 case "Alt":
					// rb.keyPress(KeyEvent.VK_ALT);
					 rb.keyRelease(KeyEvent.VK_ALT);
					 break;
				 case "Ctrl":
					// rb.keyPress(KeyEvent.VK_CONTROL); 
					 rb.keyRelease(KeyEvent.VK_CONTROL);
					 break;
				 case "Delete":
					// rb.keyPress(KeyEvent.VK_DELETE); 
					 rb.keyRelease(KeyEvent.VK_DELETE);
					 break;
				 case "Insert":
					// rb.keyPress(KeyEvent.VK_INSERT); 
					 rb.keyRelease(KeyEvent.VK_INSERT);
					 break;
				 case "Backslace":
				//	 rb.keyPress(KeyEvent.VK_BACK_SLASH); 
					 rb.keyRelease(KeyEvent.VK_BACK_SLASH);
					 break;
				 case "Backspace":
					// rb.keyPress(KeyEvent.VK_BACK_SPACE); 
					 rb.keyRelease(KeyEvent.VK_BACK_SPACE);
					 break;
		 	}
		 	}	
	public void useKeyboardPrintWord(String word) throws AWTException {
		char arrWord[]=word.toCharArray();
		for(int m=0;m<arrWord.length;m++) {
			int ascii = (int) arrWord[m];
			if(ascii>=65 && ascii<=90) {
			this.useKeyBoardGetText(arrWord[m]);
			}else if(ascii>=97 && ascii<=122) {
				this.useKeyBoardGetText(arrWord[m]);
			}else{
				this.useKeyboardGetNumber(arrWord[m]);
			}
		}
	}
}
