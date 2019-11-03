ROOT_DIR="$PWD"
ZIPKIN_JAR="${ROOT_DIR}/zipkin.jar"

buildServices(){
  echo "=> Starting builds"

  cd "${ROOT_DIR}/sorting_service/"
  echo "=> Building Sorting Service"
  ./gradlew clean build -x test
  
  cd "${ROOT_DIR}/scrambling_service/"
  echo "=> Building Scrambling Service"
  ./gradlew clean build -x test
  
  cd "${ROOT_DIR}/capitalizing_service/"
  echo "=> Building Capitalizing Service"
  ./gradlew clean build -x test
}

checkZipkin(){
  if test -f "${ZIPKIN_JAR}";then
    echo "=> Zipkin JAR already present on directory."
  else 
    echo "=> Zipkin JAR not present on directory."
    downloadZipkin
  fi
}

downloadZipkin(){
  cd "${ROOT_DIR}"
  echo "=> Downloading..."
  curl -sSL https://zipkin.io/quickstart.sh | bash -s
}

runEverything(){
  echo "=> Starting all services and Zipkin"
  java -jar "${ROOT_DIR}/sorting_service/build/libs/sorting_service.jar" &
  java -jar "${ROOT_DIR}/scrambling_service/build/libs/scrambling_service.jar" & 
  java -jar "${ROOT_DIR}/capitalizing_service/build/libs/capitalizing_service.jar" &
  java -jar "${ZIPKIN_JAR}"
  echo "=> Everything up!"
}

buildServices
checkZipkin
runEverything