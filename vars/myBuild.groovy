def call() {
    echo "🔧 Shared Library: myBuild() function is running"
    echo "Shared Library Updated Successfully!"
    echo "Building image: ${env.IMAGE}"
    sh "podman build -t ${env.IMAGE} ."
}
