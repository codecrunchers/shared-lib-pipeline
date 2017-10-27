import com.codecrunchers.ci.*
import com.codecrunchers.ci.builders.*


def call(body) {

    new com.codecrunchers.ci.PipelineDirector(
            builderId: "lambda",
            executor: "",
            serviceId: "test").
        construct(body)
}

