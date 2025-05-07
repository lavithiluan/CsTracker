package com.example.cstracker.specification;

import java.util.ArrayList;
import java.util.List;

import com.example.cstracker.model.PlayerFilter;
import org.springframework.data.jpa.domain.Specification;

import com.example.cstracker.model.Player;

import jakarta.persistence.criteria.Predicate;

public class PlayerSpecification {

    public static Specification<Player> withFilters(PlayerFilter filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.nickname() != null && !filter.nickname().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("nickname")), "%" + filter.nickname().toLowerCase() + "%"));
            }

            if (filter.time() != null && !filter.time().isEmpty()) {
                predicates.add(cb.equal(cb.lower(root.get("time")), filter.time().toLowerCase()));
            }

            if (filter.sexo() != null) {
                predicates.add(cb.equal(root.get("sexo"), filter.sexo()));
            }

            if (filter.nascimentoInicio() != null && filter.nascimentoFim() != null) {
                predicates.add(cb.between(root.get("dataNascimento"), filter.nascimentoInicio(), filter.nascimentoFim()));
            }

            if (filter.nascimentoInicio() != null && filter.nascimentoFim() == null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("dataNascimento"), filter.nascimentoInicio()));
            }

            if (filter.nascimentoInicio() == null && filter.nascimentoFim() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("dataNascimento"), filter.nascimentoFim()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
