import numpy as np

      
def peticion(instrucciones,n):
    #crear matriz
    f,c=np.shape(instrucciones)  #filas y columnas del arreglo de instrucciones
    matriz=np.zeros((f+1,n),int) # matriz de filas+1 y n columnas
    for i in range(1,f+1):
        anterior=matriz[i-1] #fila anterior de la matriz
        a=instrucciones[i-1,0] #instruccion correspondiente
        b=instrucciones[i-1,1]
        k=instrucciones[i-1,2]
        resultado=list(anterior[:]) #copiar el resultado anterior para no sobreescribir
        resultado=np.array(resultado,int)
        resultado[a-1:b]+=k #cambiar los valores entre a y b y sumarle k
        matriz[i]=resultado #colocar el valor de la instruccion en la matriz

    
    return matriz


def pedirDatos():
    a=",a"; b=",b,";k=",c";
    #while not ((len(a.split(","))+len(b.split(",")))/2==len(k.split(","))):
    while not(datosCorrectos(a)):
        a = input("Ingrese los valores de a separados por comas: ")
    while not(datosCorrectos(b)):
        b = input("Ingrese los valores de b separados por comas: ")
    while not(datosCorrectos(k)):
        k = input("Ingrese los valores de k separados por comas: ")
    return a,b,k

def generarArreglos(cadena):
    partes=[]
    partes= cadena.split(",")
    valores=[]
    for x in partes:
        valores.append(int(x))
    return valores

def datosCorrectos(cadena):
    partes=[]
    partes= cadena.split(",")
    print(partes)
    for x in partes:
        if not(str(x).isdigit()):
            return False
    return True


n="a"; 
while not(str(n).isdigit()):
    n = int (input("\nIngrese el valor de n: "))



#a,b,k=pedirDatos()
arreglo = np.array([[1,5,3], [4, 8,7], [6,9,1]])
print(peticion(arreglo,n))
