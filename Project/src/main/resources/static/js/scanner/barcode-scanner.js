/*

    EAN 13 & EAN 8 (Europe) barcode scanner
    By Guacamoleboy

    Last updated: 25/12-2025

*/

document.addEventListener("DOMContentLoaded", () => {

    // Initial
    const scanBtn = document.getElementById("scan-btn");
    const closeBtn = document.getElementById("close-scan-btn");
    const overlay = document.getElementById("scanner-overlay");
    const reader = document.getElementById("reader");

    let html5QrCode = null;
    let scanning = false;

    scanBtn.addEventListener("click", startScan);
    closeBtn.addEventListener("click", stopScan);

    // __________________________________________________________________________

    function startScan() {

        if (scanning) return;

        scanning = true;
        scanBtn.disabled = true;

        overlay.classList.remove("hidden");
        overlay.classList.add("visible");
        reader.style.display = "block";
        reader.style.pointerEvents = "all";

        setTimeout(() => {
            html5QrCode = new Html5Qrcode("reader");

            html5QrCode.start(
                { facingMode: "environment" },
                {
                    fps: 10,
                    qrbox: { width: 250, height: 100 },
                    formatsToSupport: [
                        Html5QrcodeSupportedFormats.EAN_8,
                        Html5QrcodeSupportedFormats.EAN_13
                    ]
                },
                onScanSuccess
            ).catch(err => {
                console.error("Kamera kunne ikke startes:", err);
            });
        }, 50);
    }

    // __________________________________________________________________________

    function onScanSuccess(decodedText) {

        console.log("EAN:", decodedText); // DEBUG

        if (html5QrCode) {
            html5QrCode.stop().then(() => {
                html5QrCode.clear();
                html5QrCode = null;
                showNotification("Scannet: " + decodedText, "green");
            }).catch(err => {
                console.error("Kunne ikke stoppe scanneren:", err);
            });
        } else {
            showNotification("Scannet: " + decodedText, "green");
        }

        scanning = false;
        scanBtn.disabled = false;
        overlay.classList.remove("visible");
        overlay.classList.add("hidden");
        reader.style.display = "none";
        reader.style.pointerEvents = "none";
    }

    // __________________________________________________________________________

    function stopScan() {
        if (!scanning) return;

        scanning = false;
        scanBtn.disabled = false;

        overlay.classList.remove("visible");
        overlay.classList.add("hidden");
        reader.style.display = "none";
        reader.style.pointerEvents = "none";

        if (html5QrCode) {
            html5QrCode.stop().then(() => {
                html5QrCode.clear();
                html5QrCode = null;
            });
        }
    }

});