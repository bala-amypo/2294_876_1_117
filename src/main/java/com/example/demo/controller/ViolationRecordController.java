@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {

    private final ViolationRecordService violationService;

    public ViolationRecordController(ViolationRecordService violationService) {
        this.violationService = violationService;
    }

    // POST /api/violations
    @PostMapping
    public ResponseEntity<ViolationRecord> log(@RequestBody ViolationRecord record) {
        return ResponseEntity.ok(violationService.logViolation(record));
    }

    // GET /api/violations/user/{userId}
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ViolationRecord>> byUser(@PathVariable Long userId) {
        return ResponseEntity.ok(violationService.getViolationsByUser(userId));
    }

    // PUT /api/violations/{id}/resolve
    @PutMapping("/{id}/resolve")
    public ResponseEntity<ViolationRecord> resolve(@PathVariable Long id) {
        return ResponseEntity.ok(violationService.markResolved(id));
    }

    // GET /api/violations/unresolved
    @GetMapping("/unresolved")
    public ResponseEntity<List<ViolationRecord>> unresolved() {
        return ResponseEntity.ok(violationService.getUnresolvedViolations());
    }

    // GET /api/violations
    @GetMapping
    public ResponseEntity<List<ViolationRecord>> all() {
        return ResponseEntity.ok(violationService.getAllViolations());
    }
}
