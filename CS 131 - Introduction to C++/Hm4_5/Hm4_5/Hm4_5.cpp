#include <iostream>

using namespace std;

int main()
{
	int highest_num, lowest_num, series, serie, number;
	
	cout << "How many series do you want to input? : "; //ask user to input number of series
	cin >> series;
	highest_num = 0;
	lowest_num = 100; 
	
	for (serie = 0; serie < series; serie++)
	{
		cout << "Please, Enter the number which is between 0~99: ";
		cin >> number;
		while (number < 0 || number > 99)
		{
			cout << "Please, Enter the number which is between 0~99: "; // make sure that user put number which is between 0 to 99
			cin >> number;
		}
		if (number > highest_num) // get the highest number
			highest_num = number;
		if (number < lowest_num) // get lowest number
			lowest_num = number;
	}
	
	cout << "Lowest Number is : " << lowest_num << endl;
	cout << "Highest Number is : " << highest_num << endl;
	system("pause");
	return 0;
}