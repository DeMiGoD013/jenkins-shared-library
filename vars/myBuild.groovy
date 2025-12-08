def call() {
    echo "🔧 Shared Library: myBuild() function is running"
    echo "Shared Library Updated Successfully!"
    echo "This automatically pulling the code"
    echo "Building image: ${env.IMAGE}"
    sh "podman build -t ${env.IMAGE} ."
}
