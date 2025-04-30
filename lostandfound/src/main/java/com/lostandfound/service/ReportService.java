package com.lostandfound.service;

import com.lostandfound.entity.Report;
import com.lostandfound.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Nkurikiyimana Aimable
 * Reg No: 24582/2024
 */

@Service
public class ReportService {
    @Autowired
    private LostItemService lostItemService;

    @Autowired
    private FoundItemService foundItemService;

    @Autowired
    private UserService userService;

    @Autowired
    private ReportRepository reportRepository;

    public Report createReport(Report report) {
        // Fetch the full objects before saving
        report.setLostItem(lostItemService.getLostItemById(report.getLostItem().getId()));
        report.setFoundItem(foundItemService.getFoundItemById(report.getFoundItem().getId()));
        report.setReporter(userService.getUserById(report.getReporter().getId()));
        return reportRepository.save(report);
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Report updateStatus(Long id, String status) {
        Report report = reportRepository.findById(id).orElseThrow();
        report.setStatus(status);
        return reportRepository.save(report);
    }
}
