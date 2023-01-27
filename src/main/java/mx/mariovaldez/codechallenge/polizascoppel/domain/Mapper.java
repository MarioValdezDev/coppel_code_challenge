package mx.mariovaldez.codechallenge.polizascoppel.domain;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface Mapper<Input,Output> {

    public Output map(Input input);

    public List<Output> map(List<Input> values);
}

