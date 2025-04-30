package com.lostandfound.controller;

import com.lostandfound.entity.Report;
import com.lostandfound.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Nkurikiyimana Aimable
 * Reg No: 24582/2024
 */
@RestController
@RequestMapping("/api/v1/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping
    public Report createReport(@RequestBody Report report) {
        return reportService.createReport(report);
    }

    @GetMapping
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    @PatchMapping("/{id}")
    public Report updateStatus(@PathVariable Long id, @RequestParam String status) {
        return reportService.updateStatus(id, status);
    }
}
