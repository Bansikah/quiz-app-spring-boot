## Explanation of Kubernetes and Docker Commands :

# Docker Commands:

```plain
docker build -t bansikah/quiz-app-spring-boot:v1.0 .
```
This command builds a Docker image based on the Dockerfile in your current directory.
-t: Option to tag the image.

``bansikah/quiz-app-spring-boot:v1.0``: The tag for the image, specifying your Docker Hub username (bansikah), image name (quiz-app-spring-boot), and version (v1.0).
.: Instructs Docker to build the image from the current directory (where the Dockerfile resides).

``docker push bansikah/quiz-app-spring-boot:v1.0``

This command pushes the previously built image (bansikah/quiz-app-spring-boot:v1.0) to your Docker Hub repository.
You'll need to be logged in to Docker Hub for this command to work.
Kubernetes Commands:

# Deployment and Pods:
```
kubectl apply -f k8s-deployment.yaml (potentially duplicated)
```
This command applies the configuration defined in the YAML file k8s-deployment.yaml to your Kubernetes cluster.
The YAML file likely specifies how to deploy your containerized application (e.g., number of replicas, resource requirements).
Kubernetes will create or update deployment objects based on the YAML file's instructions. Deployments manage the creation and scaling of pods.

``kubectl get pods``

This command retrieves information about all pods currently running in your Kubernetes cluster.
Pods are the basic unit of deployment in Kubernetes, representing a group of one or more containers that share storage.

``kubectl logs quiz-app-spring-boot-5c96c58d8-kdjks``

This command retrieves the logs from a specific pod named quiz-app-spring-boot-5c96c58d8-kdjks.
The pod name might be different based on your deployment configuration.
This can be helpful for debugging your application running in the pod.
Services:

``kubectl get service``

This command lists all services currently defined in your Kubernetes cluster.
Services provide a way to access a set of pods as a single unit. They handle load balancing across pods and expose endpoints for accessing your application.

``kubectl apply -f k8s-service.yaml (potentially duplicated)``

This command applies the configuration defined in the YAML file k8s-service.yaml to your Kubernetes cluster.
The YAML file likely specifies how to expose your deployed application as a service. This could involve defining ports, service types (e.g., LoadBalancer), and selectors to target pods.
Cluster Information:

``kubectl get nodes -o wide``

This command retrieves information about all worker nodes in your Kubernetes cluster, including details like machine name, operating system, CPU/memory resources, and status.
The -o wide option provides more detailed output.

``minikube ip``

Assuming you're using Minikube as your local Kubernetes cluster, this command displays the IP address of your Minikube VM.
This IP address might be useful for accessing your externally exposed service (if configured).

``minikube dashboard``

This command opens the Minikube dashboard in your web browser (usually at https://localhost:8443).
The Minikube dashboard provides a visual interface to manage your local Kubernetes cluster and view resource details.
By understanding these commands, you can effectively manage your containerized applications deployed on a Kubernetes cluster.

# Commands used
```plain
 minikube dashboard
 minikube ip
kubectl get nodes -o wide
kubectl get service
 kubectl apply -f k8s-service.yaml
kubeclt apply -f k8s-service.yaml
 kubectl logs quiz-app-spring-boot-5c96c58d8-kdjks
 kubectl get pods
 kubectl get deployments
 kubectl apply -f k8s-deployment.yaml
docker push bansikah/quiz-app-spring-boot:v1.0
docker build -t bansikah/quiz-app-spring-boot:v1.0 .

```