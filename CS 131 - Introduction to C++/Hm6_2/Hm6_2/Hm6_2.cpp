#include <iostream>
#include <string>

using namespace std;

char Correct[20] = { {'A'}, {'D'}, {'B'}, {'B'}, {'C'}, {'B'}, {'A'}, {'B'}, {'C'}, {'D'}, {'A'}, {'C'}, {'D'}, {'B'}, {'D'},{'C'}, {'C'}, {'A'}, {'D'}, {'B'} };

char Answer[20];

int main()
{
	int count = 0, correctly = 0;
	for (count = 0; count < 20; count++)
	{
		cout << "What is your answer for number " << count + 1 << " ? :";
		cin >> Answer[count];
		while (Answer[count] != 'A' && Answer[count] != 'B' && Answer[count] != 'C' && Answer[count] !=	'D')
		{
			cout << "\nPlease, Enter A, B, C, or D" << endl;
			cout << "What is your answer for number " << count + 1 << " ? :";
			cin >> Answer[count];
		}
		if (Answer[count] = Correct[count])
			correctly += 1;
	}
	if (correctly >= 15)
		cout << "You passed the driving test!! Congraturation!! " << endl;
	else if (correctly < 15)
		cout << "You didn't pass the test... try again next time!!" << endl;

	system("pause");
	return 0;
}