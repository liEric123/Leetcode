/**
 * LeetCode Visualizer - Shared JavaScript
 * Version: 1.0
 * Last Updated: 2025-12-09
 *
 * This file contains all standardized functionality for LeetCode visualizations.
 * Include this file in all visualization HTML files for consistent behavior.
 *
 * USAGE:
 * 1. Set PROBLEM_NAME before loading this script
 * 2. Implement problem-specific algorithm generators
 * 3. Call initVisualizer() after DOM loads
 */

/* ==================== CONFIGURATION ==================== */

// PROBLEM_NAME should be defined in HTML
if (typeof PROBLEM_NAME === 'undefined') {
    window.PROBLEM_NAME = 'leetcode';
}

const INPUT_LIMIT = 20; // Maximum input size for visualization

/* ==================== DARK MODE ==================== */

class DarkModeManager {
    constructor(problemName) {
        this.storageKey = `${problemName}DarkMode`;
        this.toggle = document.getElementById('darkModeToggle');
        this.body = document.body;
        this.init();
    }

    init() {
        // Check for saved preference
        const isDarkMode = localStorage.getItem(this.storageKey) === 'true';
        if (isDarkMode) {
            this.body.classList.add('dark-mode');
            this.toggle.textContent = '☀️';
        }

        // Add click listener
        this.toggle.addEventListener('click', () => this.toggleDarkMode());
    }

    toggleDarkMode() {
        this.body.classList.toggle('dark-mode');
        const isDark = this.body.classList.contains('dark-mode');
        this.toggle.textContent = isDark ? '☀️' : '🌙';
        localStorage.setItem(this.storageKey, isDark);
    }
}

/* ==================== VIDEO MANAGER ==================== */

class VideoManager {
    constructor(problemName) {
        this.storageKeyExpanded = `${problemName}VideoExpanded`;
        this.storageKeyTimestamps = `${problemName}Timestamps`;
        this.videoToggle = document.getElementById('videoToggle');
        this.videoContent = document.getElementById('videoContent');
        this.videoFrame = document.getElementById('videoFrame');
        this.timestampsList = document.getElementById('timestampsList');
        this.timestamps = [];
        this.videoExpanded = true;
        this.init();
    }

    init() {
        // Setup collapse/expand
        this.videoToggle.addEventListener('click', () => this.toggle());

        // Restore video state
        const savedState = localStorage.getItem(this.storageKeyExpanded);
        if (savedState === 'false') {
            this.videoExpanded = false;
            this.videoContent.classList.add('collapsed');
            this.videoToggle.textContent = '+';
        }

        // Load timestamps
        this.loadTimestamps();
    }

    toggle() {
        this.videoExpanded = !this.videoExpanded;
        this.videoContent.classList.toggle('collapsed');
        this.videoToggle.textContent = this.videoExpanded ? '−' : '+';
        localStorage.setItem(this.storageKeyExpanded, this.videoExpanded);
    }

    loadTimestamps() {
        const saved = localStorage.getItem(this.storageKeyTimestamps);
        if (saved) {
            this.timestamps = JSON.parse(saved);
            this.renderTimestamps();
        }
    }

    saveTimestamps() {
        localStorage.setItem(this.storageKeyTimestamps, JSON.stringify(this.timestamps));
    }

    renderTimestamps() {
        this.timestampsList.innerHTML = '';
        this.timestamps.forEach((ts, idx) => {
            const btn = document.createElement('button');
            btn.className = 'timestamp-btn';
            btn.innerHTML = `${ts.label} (${ts.time})<button class="delete-ts">×</button>`;
            btn.onclick = (e) => {
                if (e.target.classList.contains('delete-ts')) {
                    this.timestamps.splice(idx, 1);
                    this.saveTimestamps();
                    this.renderTimestamps();
                } else {
                    this.jumpToTimestamp(ts.time);
                }
            };
            this.timestampsList.appendChild(btn);
        });
    }

    jumpToTimestamp(timeStr) {
        const seconds = this.timeToSeconds(timeStr);
        if (seconds !== null && this.videoFrame.src.includes('youtube.com/embed')) {
            const videoId = new URL(this.videoFrame.src).pathname.split('/').pop();
            this.videoFrame.src = `https://www.youtube.com/embed/${videoId}?start=${seconds}`;
        }
    }

    timeToSeconds(timeStr) {
        const parts = timeStr.split(':');
        if (parts.length !== 2) return null;
        const minutes = parseInt(parts[0]);
        const seconds = parseInt(parts[1]);
        if (isNaN(minutes) || isNaN(seconds)) return null;
        return minutes * 60 + seconds;
    }
}

/* ==================== INPUT VALIDATION ==================== */

class InputValidator {
    constructor() {
        this.inputModal = document.getElementById('inputModal');
        this.modalMessage = document.getElementById('modalMessage');
        this.modalReduceBtn = document.getElementById('modalReduceBtn');
        this.modalStatsBtn = document.getElementById('modalStatsBtn');
        this.init();
    }

    init() {
        this.modalReduceBtn.addEventListener('click', () => this.closeModal());
    }

    closeModal() {
        this.inputModal.classList.remove('active');
    }

    validateArray(inputValue, inputLimit = INPUT_LIMIT) {
        const inputArray = inputValue.split(',').map(n => parseInt(n.trim()));

        if (inputArray.some(isNaN)) {
            alert('Please enter valid numbers');
            return { valid: false };
        }

        if (inputArray.length > inputLimit) {
            this.modalMessage.innerHTML = `Your input has <strong>${inputArray.length}</strong> items, but visualization works best with ≤${inputLimit} items.`;
            this.inputModal.classList.add('active');
            return { valid: false, shouldShowStats: true, data: inputArray };
        }

        return { valid: true, data: inputArray };
    }

    validateNumber(inputValue) {
        const num = parseInt(inputValue);
        if (isNaN(num)) {
            alert('Please enter a valid number');
            return { valid: false };
        }
        return { valid: true, data: num };
    }

    setStatsCallback(callback) {
        this.modalStatsBtn.addEventListener('click', async () => {
            this.closeModal();
            await callback();
        });
    }
}

/* ==================== SPEED CONTROL ==================== */

class SpeedController {
    constructor() {
        this.speedSlider = document.getElementById('speedSlider');
        this.speedValue = document.getElementById('speedValue');
        this.speed = 0.3;
        this.init();
    }

    init() {
        this.speedSlider.addEventListener('input', (e) => {
            const val = parseInt(e.target.value);
            this.speed = val / 10;
            this.speedValue.textContent = this.speed.toFixed(1) + 'x';
        });
    }

    getSpeed() {
        return this.speed;
    }

    getDelay() {
        return 1000 / this.speed;
    }
}

/* ==================== CODE HIGHLIGHTER ==================== */

class CodeHighlighter {
    highlightCode(panelIdPrefix, lineNum) {
        // Handle both cpp and java code panels
        const panels = [
            document.getElementById(panelIdPrefix + 'Cpp'),
            document.getElementById(panelIdPrefix + 'Java')
        ];

        panels.forEach(panel => {
            if (!panel) return;
            panel.querySelectorAll('.code-line').forEach(line => {
                line.classList.remove('active');
            });
            if (lineNum) {
                const line = panel.querySelector(`[data-line="${lineNum}"]`);
                if (line) line.classList.add('active');
            }
        });
    }

    setupLanguageToggle() {
        document.querySelectorAll('.lang-btn').forEach(btn => {
            btn.addEventListener('click', function() {
                const lang = this.getAttribute('data-lang');
                const algo = this.getAttribute('data-algo');

                // Update button states
                const parent = this.parentElement;
                parent.querySelectorAll('.lang-btn').forEach(b => b.classList.remove('active'));
                this.classList.add('active');

                // Toggle code panels
                if (algo) {
                    const cppPanel = document.getElementById(algo + 'CodeCpp');
                    const javaPanel = document.getElementById(algo + 'CodeJava');
                    if (cppPanel && javaPanel) {
                        cppPanel.style.display = lang === 'cpp' ? 'block' : 'none';
                        javaPanel.style.display = lang === 'java' ? 'block' : 'none';
                    }
                } else {
                    // Single code panel case
                    const cppPanel = document.getElementById('codePanelCpp');
                    const javaPanel = document.getElementById('codePanelJava');
                    if (cppPanel && javaPanel) {
                        cppPanel.style.display = lang === 'cpp' ? 'block' : 'none';
                        javaPanel.style.display = lang === 'java' ? 'block' : 'none';
                    }
                }
            });
        });
    }
}

/* ==================== ANIMATION CONTROLLER ==================== */

class AnimationController {
    constructor(speedController) {
        this.speedController = speedController;
        this.isRunning = false;
        this.isPaused = false;
        this.stepMode = false;
        this.generator = null;
    }

    async start(generatorFunction, isStepMode = false) {
        this.isRunning = true;
        this.stepMode = isStepMode;
        this.isPaused = isStepMode;
        this.generator = generatorFunction();

        if (!this.stepMode) {
            await this.continue();
        } else {
            await this.step();
        }
    }

    async continue() {
        while (!this.isPaused && this.isRunning) {
            await this.step();
            if (this.generator === null) {
                break;
            }
        }
    }

    async step() {
        if (this.generator) {
            const result = this.generator.next();
            if (result.done) {
                this.generator = null;
                this.isRunning = false;
                return true; // Animation complete
            }
        }

        if (!this.stepMode && this.isRunning) {
            await this.sleep(this.speedController.getDelay());
        }

        return false; // Animation continues
    }

    pause() {
        this.isPaused = true;
    }

    resume() {
        this.isPaused = false;
    }

    reset() {
        this.isRunning = false;
        this.isPaused = false;
        this.generator = null;
        this.stepMode = false;
    }

    sleep(ms) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }
}

/* ==================== UI UPDATER ==================== */

class UIUpdater {
    updateStepInfo(elementId, text) {
        const element = document.getElementById(elementId);
        if (element) {
            element.textContent = text;
        }
    }

    updateStat(elementId, value) {
        const element = document.getElementById(elementId);
        if (element) {
            element.textContent = value;
        }
    }

    showResult(elementId, message) {
        const element = document.getElementById(elementId);
        if (element) {
            element.innerHTML = message;
            element.classList.add('show');
        }
    }

    hideResult(elementId) {
        const element = document.getElementById(elementId);
        if (element) {
            element.classList.remove('show');
        }
    }
}

/* ==================== UTILITIES ==================== */

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

function formatNumber(num) {
    return num.toLocaleString();
}

/* ==================== GLOBAL INSTANCES ==================== */

let darkModeManager;
let videoManager;
let inputValidator;
let speedController;
let codeHighlighter;
let uiUpdater;

/* ==================== INITIALIZATION ==================== */

function initVisualizer() {
    // Initialize all managers
    darkModeManager = new DarkModeManager(PROBLEM_NAME);
    videoManager = new VideoManager(PROBLEM_NAME);
    inputValidator = new InputValidator();
    speedController = new SpeedController();
    codeHighlighter = new CodeHighlighter();
    uiUpdater = new UIUpdater();

    // Setup language toggle
    codeHighlighter.setupLanguageToggle();

    console.log(`${PROBLEM_NAME} visualizer initialized`);
}

/* ==================== EXPORTS ==================== */

// Make managers available globally
window.VisualizerTemplate = {
    DarkModeManager,
    VideoManager,
    InputValidator,
    SpeedController,
    CodeHighlighter,
    AnimationController,
    UIUpdater,
    initVisualizer,
    sleep,
    formatNumber
};