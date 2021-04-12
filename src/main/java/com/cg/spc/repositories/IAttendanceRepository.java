package com.cg.spc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.spc.entities.Attendance;

public interface IAttendanceRepository extends JpaRepository<Attendance, Integer>{

}
