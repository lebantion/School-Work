#include <iostream>

using namespace std;

const int SIZE = 5;
int Function[SIZE] = { 2, 4, 6, 8, 10 };
void copy_double(int[]);

int main()
{
	copy_double(Function);

	system("pause");
	return 0;
}

void copy_double(int array[SIZE])
{
	int *ptr = nullptr;
	ptr = new int[SIZE * 2];
	for (int count = 0; count < (SIZE * 2); count++)
	{
		ptr[count] = array[count];
	}
	for (int count = 0; count < (SIZE * 2); count++)
	{
		cout << ptr[count] << endl;
	}

	delete[]ptr;
}