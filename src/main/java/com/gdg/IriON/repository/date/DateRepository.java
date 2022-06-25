package com.gdg.IriON.repository.date;

import com.gdg.IriON.entity.date.DateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateRepository extends JpaRepository<DateEntity, Long> {
}
