package io.github.butcher.butcher.back.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="counter_option")
public class CounterOption {
    @Id
    @GenericGenerator(name = "counter_option_id_seq", strategy = PostgreSQLConstants.SEQUENCE_GENERATOR_STRATEGY, parameters = {@org.hibernate.annotations.Parameter(name = "sequence_name", value = "counter_option_id_seq"), @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")})
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "counter_option_id_seq")
    private Long id;

    @ManyToOne
    private Option option_id;

    @ManyToOne
    private Option counter_option_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Option getOption_id() {
        return option_id;
    }

    public void setOption_id(Option option_id) {
        this.option_id = option_id;
    }

    public Option getCounter_option_id() {
        return counter_option_id;
    }

    public void setCounter_option_id(Option counter_option_id) {
        this.counter_option_id = counter_option_id;
    }
}
