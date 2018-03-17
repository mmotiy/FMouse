#include <stdio.h>
#define WINVER 0x0500
#include <windows.h>

int main(int argc, char const *argv[])
{
	printf("%d\n", sizeof(DWORD));
	printf("%d\n", sizeof(LONG));
	printf("%d\n", sizeof(int));
	return 0;
}