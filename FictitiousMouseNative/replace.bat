g++ -m64  -Wl,--add-stdcall-alias -I"D:\Java\include" -I"D:\Java\include\win32" -shared -o Mouse.dll com_mmotiy_service_Mouse.c
DEL D:\Mouse.dll
MOVE Mouse.dll D:\