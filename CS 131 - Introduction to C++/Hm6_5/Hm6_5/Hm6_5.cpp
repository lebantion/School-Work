#include <iostream>

using namespace std;

int account_num[18] = { 5658845, 4520125, 7895122, 8777541, 8451277, 1302850,
					    8080152, 4562555, 5552012, 5050552, 7825877, 1250255,
					    1005231, 6545231, 3852085, 7576651, 7881200, 4581002 };


int binarySearch(const int array[], int SIZE, int value)
{
	int first = 0,           
		last = SIZE - 1,     
		middle,                
		position = -1;         
	bool found = false;        

	while (first < last && !found)
	{
		middle = (first + last) / 2;
		if (array[middle] == value)
		{
			found = true;	
			position = middle;   

		}
		else if (array[middle] > value) 
			last = middle + 1;
		else
			last = middle - 1;          
	}
	return position;
}

int selectionSort(int array[], int size)
{
	int startScan;    
	int minIndex;
	long minValue;

	for (startScan = 0; startScan < (size - 1); startScan++)
	{
		minIndex = startScan;
		minValue = array[startScan];

		for (int index = startScan + 1; index < size; index++)
		{
			if (array[index] < minValue)
			{
				minValue = array[index];
				minIndex = index;
			}
		}
		array[minIndex] = array[startScan];
		array[startScan] = minValue;
	}

	return 0;
}

int main()
{
	int empID, results, exchanges;

	exchanges = selectionSort(account_num, 18);
	
	cout << "Enter the employee ID you to search for: ";
	cin >> empID;
	
	results = binarySearch(account_num, 18, empID);
	
	if (results == -1)
		cout << "That number is invalid" << endl;
	else
		cout << "That number is valid!! " << endl;

	system("pause");
	return 0;
}