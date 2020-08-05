package com.example.back.repository;

import com.example.back.model.MROData;
import com.example.back.model.MRODataKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MRODataRepository extends JpaRepository<MROData, MRODataKey> {


}
