const scanBtn = document.getElementById("scan-btn");
const video = document.getElementById("camera");

scanBtn.addEventListener("click", async () => {

    if (!("BarcodeDetector" in window)) {
        alert("Barcode scanning understøttes ikke i denne browser");
        return;
    }

    const stream = await navigator.mediaDevices.getUserMedia({
        video: { facingMode: "environment" }
    });

    video.srcObject = stream;
    video.style.display = "block";

    const detector = new BarcodeDetector({
        formats: ["ean_13", "ean_8"]
    });

    const scan = async () => {
        const barcodes = await detector.detect(video);

        if (barcodes.length > 0) {
            const ean = barcodes[0].rawValue;

            console.log("EAN:", ean);

            stream.getTracks().forEach(t => t.stop());
            video.style.display = "none";

            fetch("/barcode", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({ ean })
            });

        } else {
            requestAnimationFrame(scan);
        }
    };

    scan();

});