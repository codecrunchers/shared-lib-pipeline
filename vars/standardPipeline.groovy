def call(body) {

    new com.codecrunchers.ci.PipelineDirector(
            builderId: "lambda",
            executor: "",
            serviceId: "test"
            ).construct(body)
}

