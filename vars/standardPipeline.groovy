import com.codecrunchers.ci.*


def call(body) {

    new PipelineDirector(
            builderId: "lambda",
            executor: "test-executor",
            serviceId: "test").
        construct(body)
}

