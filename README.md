# Blog application

Sample blog application to demonstrate the CI/CD pipeline using GitHub action

### Endpoints :
We have expose the HTTP GET endpoint on `/api/v1/check` path on port 8080. we can try hitting this in curl or in web browser
```bash
curl -X GET http://localhost:8080/api/v1/check
```
docker build -t blog-app .

### Docker
The application is containerized using Docker. The Dockerfile is configured to use Amazon Corretto as the base image. To build and run the Docker container:
#### Install Docker 
```shell
curl -fsSL https://get.docker.com -o get-docker.sh
sudo sh ./get-docker.sh
```
#### Build the Docker Image
```docker
docker build -t blog-app .
```

#### Run the Docker Container
```docker
docker run --name blog-app -p 8080:8080 blog-app
```

Kubernetes
To deploy the application in a Kubernetes cluster, create the necessary deployment and service YAML files. Below is an example:
#### Deployment YAML

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: blog-app
spec:
  replicas: 2
  selector:
    matchLabels:
      app: blog-app
  template:
    metadata:
      labels:
        app: blog-app
    spec:
      containers:
      - name: blog-app
        image: blog-app:latest
        ports:
        - containerPort: 8080
```

#### Service YAML
```yaml
apiVersion: v1
kind: Service
metadata:
  name: blog-app-service
spec:
  selector:
    app: blog-app
  ports:
    - protocol: TCP
      port: 8080
      targetPort: 8080
  type: LoadBalancer
```

#### Apply the Configuration

```shell
kubectl apply -f deployment.yaml
kubectl apply -f service.yaml
```

### Azure infrastructure 

create cluster with blow command:
```shell
az aks create \
  --resource-group $resource \
  --name blog_application \
  --node-count 2 \
  --generate-ssh-keys
```

### References
- [application.properties:](./src/main/resources/application.properties) Configuration for the Spring Boot application.
- [Rest Controller](./src/main/java/com/devtiro/blog/controller/BlogController.java) for API
- [Dockerfile](./Dockerfile): Docker configuration for containerizing the application.
- [Kubernetes](./k8s)


