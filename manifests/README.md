# Ejercicio 6 - Pipeline con Tekton en OpenShift

Este documento detalla el proceso seguido para ejecutar un pipeline en Tekton que realiza:

1. Clonación del repositorio (`git-clone`)
2. Listado de archivos (`list-dir`)
3. Construcción del proyecto con Maven (`build`)
4. Construcción y push de la imagen a Docker Hub (`build-push`)

## Requerimientos Previos
- Cluster OpenShift con Tekton instalado
- Namespace: `diploe2-lfcz`
- Repositorio con la rama `feature/git-clone-build`
- Configuración de Docker Hub con un `Secret`

## Pasos de ejecución

### 1. Clonación del repositorio
```sh
kubectl create -f git-clone-run.yaml
tkn tr logs git-clone-XXXX -n diploe2-lfcz

### 2. Listado del directorio
kubectl create -f list-dir-run.yaml

tkn tr logs list-dir-XXXX -n diploe2-lfcz

### 3. copilacion maven
kubectl create -f build-run.yaml
tkn tr logs build-XXXX -n diploe2-lfcz

### 4. Construcción y Push de la imagen
kubectl create -f buildah-run.yaml
tkn tr logs buildah-run-XXXX -n diploe2-lfcz

