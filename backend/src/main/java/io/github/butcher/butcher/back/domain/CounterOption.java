package io.github.butcher.butcher.back.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class CounterOption {
    @Id
    @GenericGenerator(name = "counter_option_id_seq", strategy = PostgreSQLConstants.SEQUENCE_GENERATOR_STRATEGY, parameters = {@org.hibernate.annotations.Parameter(name = "sequence_name", value = "counter_option_id_seq"), @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")})
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "counter_option_id_seq")
    private Long id;

    @ManyToOne
    private Option option;

    @ManyToOne
    private Option counterOption;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public Option getCounterOption() {
        return counterOption;
    }

    public void setCounterOption(Option counterOption) {
        this.counterOption = counterOption;
    }
}
