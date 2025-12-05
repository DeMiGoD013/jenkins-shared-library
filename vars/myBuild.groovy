def call() {
    echo "Building image: ${env.IMAGE}"
    sh "podman build -t ${env.IMAGE} ."
}
