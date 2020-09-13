#include <iostream>
#include <iomanip>
#include <string>
using namespace std;
const int COLS = 30, ROWS = 15;
double total = 0;

void seatingChart(char[][COLS], int);
void Price_Chosing(double array[]);


int main()
{
	char seating[ROWS][COLS];
	double prices[ROWS] =
	{ 12.00,
	  13.00,
	  12.00,
	  15.00,
	  16.00,
	  15.00,
	  14.00,
	  15.00,
	  16.00,
	  13.00,
	  14.0,
	  12.00,
	  11.00,
	  13.00,
	  12.00 };



	for (int count = 0; count < ROWS; count++)
	{
		for (int count1 = 0; count1 < COLS; count1++)
		{
			seating[count][count1] = '#';
		}
	}

	seatingChart(seating, ROWS);

	cout << "-----------------------------------------" << endl;

	Price_Chosing(prices);

	system("pause");
	return 0;

}

void seatingChart(char arr[][COLS], int row)
{
	int width;

	for (int count = 0; count < ROWS; count++)
	{
		if ((count + 1) >= 10)
			width = 3;
		else
			width = 4;

		cout << "Row " << count + 1 << setw(width);

		for (int count1 = 0; count1 < COLS; count1++)
		{
			cout << arr[count][count1];
		}

		cout << "\n";

	}
}
void Price_Chosing(double arr[])
{
	int chosingrow;
	int chosingcol;
	int ticketnum;
	
	cout << "How many ticket do you want to buy? : ";
	cin >> ticketnum;

	for (int count = 0; count < ticketnum; count++)
	{
		cout << "---------------------------------" << endl;
		cout << "Which Row do you want to reserve? : ";
		cin >> chosingrow;
		cout << "---------------------------------" << endl;
		while (chosingrow < 1 || chosingrow > 15)
		{
			cout << "Please select row number between 1 to 15  " << endl;
			cout << "Which Row do you want to reserve? : ";
			cin >> chosingrow;
			cout << "---------------------------------" << endl;
		}

		cout << "Which Column do you want to reserve? : ";
		cin >> chosingcol;
		cout << "---------------------------------" << endl;
		
		while (chosingcol < 0  || chosingcol > 30)
		{
			cout << "Please select row number between 1 to 30  " << endl;
			cout << "Which Column do you want to reserve? : ";
			cin >> chosingcol;
			cout << "---------------------------------" << endl;
		}

		cout << "Ticket number #" << count + 1 << " seat price is " << arr[chosingrow - 1] << " $" << endl;
		total += arr[chosingrow - 1];
	}
	cout << "---------------------------------" << endl;
	cout << "The total is : " << total << " $" << endl;
}