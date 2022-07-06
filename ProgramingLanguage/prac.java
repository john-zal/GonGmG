package GonGmG.ProgramingLanguage;

public class prac {
    int j = -3;
	int key = j + 2;
	for (int i = 0; i < 3; i++) {
		if ((key == 3) || (key == 2))
			j--;
		else if (key == 0)
			j += 2;
		else
			j = 0;
		if (j > 0)
			break;
		else
			j = 3 - i;
	}
}
